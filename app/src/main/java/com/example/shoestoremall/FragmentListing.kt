package com.example.shoestoremall



    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.TextView
    import androidx.fragment.app.Fragment
    import androidx.fragment.app.viewModels
    import androidx.lifecycle.Observer
    import androidx.navigation.fragment.findNavController

    import com.example.shoestoremall.data.ShoeData
    import com.example.shoestoremall.databinding.FragmentListingBinding

class FragmentListing : Fragment() {
        private var _binding: FragmentListingBinding? = null
        private val binding get() = _binding!!

        private val viewModel: ShoeViewModel by viewModels()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentListingBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes ->
                updateShoeList(shoes)
            })

            binding.addShoeFAB.setOnClickListener {
                findNavController().navigate(R.id.action_fragment_listing_to_fragment_details)
            }
        }

        private fun updateShoeList(shoes: List<ShoeData>) {
            val shoeListLayout = binding.shoeList
            shoeListLayout.removeAllViews()

            shoes.forEach { shoe ->
                val shoeItemView = LayoutInflater.from(context).inflate(R.layout.shoe_details, shoeListLayout, false)
                val shoeName = shoeItemView.findViewById<TextView>(R.id.nameTextView)
     //           val shoeSize = shoeItemView.findViewById<TextView>(R.id.sizeTextView)
                val shoeCompany = shoeItemView.findViewById<TextView>(R.id.companyTextView)
                val shoeDescription = shoeItemView.findViewById<TextView>(R.id.descriptionTextView)

                shoeName.text = shoe.name
      //          shoeSize.text = shoe.size.toString()
                shoeCompany.text = shoe.company
                shoeDescription.text = shoe.description

                shoeListLayout.addView(shoeItemView)
            }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
