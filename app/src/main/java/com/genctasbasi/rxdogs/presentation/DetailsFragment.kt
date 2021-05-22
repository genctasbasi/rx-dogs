package com.genctasbasi.rxdogs.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.genctasbasi.rxdogs.R
import com.genctasbasi.rxdogs.data.DogApiResponse
import com.genctasbasi.rxdogs.presentation.viewModels.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_details.*
import org.koin.android.ext.android.inject

class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        show_another_button.setOnClickListener {
            viewModel.onShowAnotherClick()
        }

        viewModel.dogsLive.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                Toast.makeText(
                    context, getString(R.string.no_dogs_found), Toast.LENGTH_LONG
                ).show()
            } else {
                setFirstDogImage(it.first())
            }
        }

        // show the first doggy
        viewModel.onShowAnotherClick()
    }

    private fun setFirstDogImage(data: DogApiResponse) {
        Glide.with(this)
            .load(data.url)
            .fitCenter()
            .into(dog_image);
    }
}