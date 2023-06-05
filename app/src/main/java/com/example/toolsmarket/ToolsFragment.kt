package com.example.toolsmarket

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toolsmarket.adapters.ToolListAdapter
import com.example.toolsmarket.dagger.DaggerAppComponent
import com.example.toolsmarket.databinding.FragmentToolsBinding
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.viewModels.ToolsFragmentViewModel
import javax.inject.Inject

class ToolsFragment : Fragment() {

    private var _binding: FragmentToolsBinding? = null
    private val toolsAdapter = ToolListAdapter()

    @Inject
    lateinit var vm : ToolsFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = DaggerAppComponent.builder()
            .build()
        component.inject(this)
    }

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToolsBinding.inflate(inflater, container, false)
        init()
        vm.init()
        return binding.root
    }

    private fun init() {
        binding.tools.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        binding.tools.adapter = toolsAdapter

        val observer = Observer<List<Tool>> { newValue ->
            toolsAdapter.submitList(newValue)
        }
        vm.liveData.observe(viewLifecycleOwner, observer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}