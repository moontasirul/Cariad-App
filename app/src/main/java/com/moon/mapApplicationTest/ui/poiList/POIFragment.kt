package com.moon.mapApplicationTest.ui.poiList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.moon.mapApplicationTest.R
import com.moon.mapApplicationTest.data.model.POI
import com.moon.mapApplicationTest.databinding.FragmentPoiBinding
import com.moon.mapApplicationTest.ui.poiDetails.POIDetailsFragment
import com.moon.mapApplicationTest.utils.Utils
import com.moon.mapApplicationTest.utils.dialogUtils.CustomDialogCallback
import com.moon.mapApplicationTest.utils.dialogUtils.CustomDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class POIFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener,
    IPOIListNavigator {

    companion object {
        const val POI_ITEM = "poi"
    }

    private lateinit var poiBinding: FragmentPoiBinding
    private val viewModel by viewModels<POIViewModel>()
    private var mMap: GoogleMap? = null

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setNavigator(this)

        if (Utils.hasInternetConnection(requireContext())) {
            val mapFragment =
                childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this)
            setupObservers()
        } else {
            showDialog(
                requireContext().getString(R.string.msg_failed),
                requireContext().resources.getString(R.string.internet_connect_message),
                true
            )
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
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
                for (poi in viewModel.poiList) {
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
            viewModel.isLoading.set(false)
        }
    }


    override fun onMarkerClick(marker: Marker): Boolean {

        // Retrieve the data from the marker.
        val carMarker = marker.tag as? POI

        // Check if a click count was set, then display the click count.
        carMarker?.let { poi ->
            if (clickCount == 2) {
                onClickedCar(poi)
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

    private fun onClickedCar(poi: POI) {
        findNavController().navigate(
            R.id.action_poiFragment_to_poiDetailFragment,
            bundleOf(POI_ITEM to poi)
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