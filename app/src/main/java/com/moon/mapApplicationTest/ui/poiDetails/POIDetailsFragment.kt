package com.moon.mapApplicationTest.ui.poiDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.moon.mapApplicationTest.R
import com.moon.mapApplicationTest.data.model.POI
import com.moon.mapApplicationTest.databinding.FragmentPoiDetailsBinding
import com.moon.mapApplicationTest.utils.dialogUtils.CustomDialogCallback
import com.moon.mapApplicationTest.utils.dialogUtils.CustomDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class POIDetailsFragment : Fragment(), IPOIDetailsNavigator {

    companion object {
        const val DIALOG_TAG = "dialog"
        const val POI_ITEM = "poi"
    }

    private lateinit var poiDetailsBinding: FragmentPoiDetailsBinding
    private val viewModel by viewModels<POIDetailsViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getParcelable<POI>(POI_ITEM)?.let { poi->
            viewModel.showPOIInfo(poi)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        poiDetailsBinding = FragmentPoiDetailsBinding.inflate(layoutInflater)
        poiDetailsBinding.lifecycleOwner = this
        poiDetailsBinding.poiDetailsViewModel = viewModel
        return poiDetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setNavigator(this)
        setupObservers()
    }

    private fun setupObservers() {

    }


    override fun showFailedDialog() {
        showDialog(
            requireContext().getString(R.string.msg_failed_title),
            requireContext().getString(R.string.msg_failed),
            true
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

                }

                override fun onPositiveClick() {
                    dialog?.dismiss()
                    findNavController().popBackStack()
                }

                override fun onCloseClick() {
                    dialog?.dismiss()
                }
            },
            isOnlyPositive,
        )
        dialog.show(childFragmentManager, DIALOG_TAG)
    }

}