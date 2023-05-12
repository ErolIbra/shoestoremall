package com.example.shoestoremall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.shoestoremall.databinding.FragmentInstructionBinding

class FragmentInstruction : Fragment() {
    private var _binding: FragmentInstructionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInstructionBinding.inflate(inflater, container, false)

        // Set up any click listeners or other UI logic here, for example:
        binding.nextButton.setOnClickListener {
            // Navigate to the next screen (e.g., ListingFragment) using the appropriate action ID from your navigation graph
            findNavController().navigate(R.id.action_fragment_instruction_to_fragment_listing)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}