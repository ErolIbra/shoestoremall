package com.example.shoestoremall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.shoestoremall.databinding.FragmentWelcomeBinding


class FragmentWelcome : Fragment() {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        binding.welcomeButton.setOnClickListener {
            // Navigate to FragmentWelcome
            findNavController().navigate(R.id.action_fragment_welcome_to_fragment_instruction)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}