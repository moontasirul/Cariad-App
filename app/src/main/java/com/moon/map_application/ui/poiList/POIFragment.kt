package com.moon.map_application.ui.poiList

import android.Manifest
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.moon.map_application.data.model.POI
import com.moon.map_application.R
import com.moon.map_application.databinding.BottomSheetDialogBinding
import com.moon.map_application.databinding.FragmentPoiBinding
import com.moon.map_application.ui.poiDetails.POIDetailsFragment
import com.moon.map_application.utils.Constants.Companion.TIMESTAMP_FORMAT
import com.moon.map_application.utils.Utils
import com.moon.map_application.utils.dialogUtils.CustomDialogCallback
import com.moon.map_application.utils.dialogUtils.CustomDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class POIFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener,
    IPOIListNavigator {

    companion object {
        private var REQUEST_CODE = 101
        const val CAR_ID = "id"
    }

    private lateinit var poiBinding: FragmentPoiBinding
    private val viewModel by viewModels<POIViewModel>()
    private var mMap: GoogleMap? = null
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var currentLocation: Location

    private var clickCount = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        poiBinding = FragmentPoiBinding.inflate(layoutInflater)
        poiBinding.lifecycleOwner = this
        poiBinding.poiViewModel = viewModel
        return poiBinding.root
    }

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                fetchLocation()
                setupObservers()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setNavigator(this)
        fusedLocationClient = LocationServices
            .getFusedLocationProviderClient(requireContext())
        if (Utils.hasInternetConnection(requireContext())) {
            fetchLocation()
            setupObservers()
        } else {
            showDialog(
                requireContext().getString(R.string.msg_failed),
                "Please Active Internet Connection",
                true
            )
        }
    }

    private fun fetchLocation() {
        activity?.let {
            if (ActivityCompat.checkSelfPermission(
                    it, Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    it, Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_CODE
                )
                requireContext().checkBackgroundLocationPermissionAPI30()
                return
            }
        }
        if (Utils.isLocationEnabled(requireContext())) {
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                if (location != null) {
                    currentLocation = location
                    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                    val mapFragment =
                        childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
                    mapFragment.getMapAsync(this)

                }
            }
        } else {
            showDialog(
                requireContext().getString(R.string.msg_failed),
                "Device Location is not enable. \n Please enable Location service.",
                true
            )
        }

    }

    private fun Context.checkSinglePermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    @TargetApi(30)
    private fun Context.checkBackgroundLocationPermissionAPI30() {

        if (checkSinglePermission(Manifest.permission.ACCESS_BACKGROUND_LOCATION)) return
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.location_permission))
            .setMessage(getString(R.string.location_permission_message))
            .setPositiveButton(getString(R.string.yes_txt)) { _, _ ->
                requestPermission.launch(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
            }
            .setNegativeButton(getString(R.string.btn_text_no)) { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        currentLocation.let { cLocation ->
            val latLng = LatLng(cLocation.latitude, cLocation.longitude)
            val markerOptions = MarkerOptions().position(latLng).title("I am here!")
            mMap?.animateCamera(CameraUpdateFactory.newLatLng(latLng))
            mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5f))
            mMap?.addMarker(markerOptions)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchLocation()
                setupObservers()
            }
        }
    }


    private fun setupObservers() {
        viewModel.isLoading.set(true)
        viewModel.fetchCarResponse()
        viewModel.response.observe(requireActivity()) { response ->
            viewModel.getCarResponse(response)
        }
    }

    override fun addPOIMarker() {
        if (Utils.isLocationEnabled(requireContext())) {
            mMap.let {
                for (poi in viewModel.carList) {
                    poi.AddressInfo?.Latitude?.let {
                        poi.AddressInfo?.Longitude?.let { it1 ->
                            LatLng(
                                it,
                                it1
                            )
                        }
                    }?.let { latLng ->
                        val markerOptions =
                            MarkerOptions().position(latLng).title(poi.AddressInfo?.Title).icon(
                                BitmapDescriptorFactory.fromResource(R.drawable.icons_car)
                            )
                        mMap?.animateCamera(CameraUpdateFactory.newLatLng(latLng))
                        mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13f))
                        mMap?.addMarker(markerOptions)?.tag = poi
                        mMap?.setOnMarkerClickListener(this)
                    }
                }
            }
        }

    }


    override fun onMarkerClick(marker: Marker): Boolean {

        // Retrieve the data from the marker.
        val carMarker = marker.tag as? POI

        // Check if a click count was set, then display the click count.
        carMarker?.let { poi ->
            if (clickCount == 2) {
                poi.ID?.let { it1 -> onClickedCar(it1) }
                clickCount = 0
            } else {
                mMap?.clear()
                poi.AddressInfo?.Latitude?.let {
                    poi.AddressInfo?.Longitude?.let { it1 ->
                        LatLng(it, it1)
                    }
                }?.let { latLng ->
                    val markerOptions =
                        MarkerOptions().position(latLng).title(poi.AddressInfo?.Title).icon(
                            BitmapDescriptorFactory.fromResource(R.drawable.icons_car)
                        )
                    mMap?.setOnMarkerClickListener(this)
                    mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18f))
                    mMap?.addMarker(markerOptions)?.tag = poi
                    mMap?.addMarker(markerOptions)?.showInfoWindow()
                }
            }
            clickCount += 1
        }

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false
    }

    private fun onClickedCar(poiId: Int) {
        findNavController().navigate(
            R.id.action_carsFragment_to_carDetailFragment,
            bundleOf(CAR_ID to poiId)
        )
    }

    fun showDialog(title: String, message: String, isOnlyPositive: Boolean) {
        var dialog: DialogFragment? = null
        var bntText = requireContext().getString(R.string.yes_txt)
        if (isOnlyPositive) {
            bntText = requireContext().getString(R.string.btn_text_ok)
        }
        dialog = CustomDialogFragment(
            title,
            message,
            bntText,
            requireContext().getString(R.string.cancel_text),
            object : CustomDialogCallback {
                override fun onNextClick() {
                    dialog?.dismiss()
                }

                override fun onPositiveClick() {
                    dialog?.dismiss()
                }

                override fun onCloseClick() {
                    dialog?.dismiss()
                }
            },
            isOnlyPositive,
        )
        dialog.show(childFragmentManager, POIDetailsFragment.DIALOG_TAG)
    }


    override fun showFailedDialog(message: String) {
        showDialog(requireContext().resources.getString(R.string.msg_failed), message, true)
    }
}