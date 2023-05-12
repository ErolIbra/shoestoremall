package com.example.shoestoremall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.example.shoestoremall.data.ShoeData
import com.example.shoestoremall.databinding.FragmentDetailsBinding

class FragmentDetails : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ShoeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        binding.saveButton.setOnClickListener {
            // Handle save button click
            // Navigate to the desired destination if needed

            val shoeData = ShoeData(
                binding.nameEditText.text.toString(),
   //             binding.sizeEditText.text.toString(),
                binding.companyEditText.text.toString(),
                binding.descriptionEditText.text.toString()
            )
            viewModel.addShoe(shoeData)
             findNavController().navigate(R.id.action_fragment_details_to_fragment_listing)
        }

        binding.cancelButton.setOnClickListener {
            // Handle cancel button click
            // Navigate to the desired destination if needed
             findNavController().navigate(R.id.action_fragment_details_to_fragment_listing)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}