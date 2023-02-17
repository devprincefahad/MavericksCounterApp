package com.example.maverickscounterapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.*
import com.example.maverickscounterapp.databinding.FragmentBlankBinding

data class MainFragmentState(val count: Int = 0) : MavericksState

class MainFragmentViewModel(initialState: MainFragmentState) :
    MavericksViewModel<MainFragmentState>(initialState) {
    fun incrementCount() {
        setState { copy(count = count + 1) }
    }
}

class BlankFragment : Fragment(), MavericksView {

    private lateinit var binding: FragmentBlankBinding
    private val viewModel: MainFragmentViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //var count = 0
        binding.fab.setOnClickListener {
            //  binding.tvCount.text = "${++count}" 
            viewModel.incrementCount()
        }
    }

    override fun invalidate() = withState(viewModel) { state ->
        binding.tvCount.text = "${state.count}"
    }

}