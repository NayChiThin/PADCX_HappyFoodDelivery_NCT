package com.padcx.happyfooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.padcx.happyfooddelivery.R
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*


class BottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnTrackOrder.setOnClickListener {
            dialog?.dismiss()
        }
        tvOrderAgain.setOnClickListener {
            activity?.finish()
        }
    }

}