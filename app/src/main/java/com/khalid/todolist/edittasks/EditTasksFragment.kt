package com.khalid.todolist.edittasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.datepicker.MaterialDatePicker
import com.khalid.todolist.R
import com.khalid.todolist.TodoListApplication
import com.khalid.todolist.databinding.FragmentEditTasksBinding
import com.khalid.todolist.utils.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class EditTasksFragment : Fragment() {
    var datePick = ""
    var datemilisec: Long = 0
private var _binding:FragmentEditTasksBinding?=null
    private val binding get() = _binding
    private val viewModel:EditTasksViewModel by activityViewModels{
        ViewModelFactory((activity?.application as TodoListApplication).repository)
    }
    private val navArg:EditTasksFragmentArgs by navArgs()

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding?.editTitle?.text.toString(),
            binding?.editDescription?.text.toString(),
            binding?.date?.text.toString()
        )
    }
    private fun edit(){
        if (isEntryValid()){
            viewModel.editNewProduct(
                binding?.editTitle?.text.toString(),
                binding?.editDescription?.text.toString(),
                binding?.date?.text.toString(),
                navArg.id
            )
            val action = EditTasksFragmentDirections.actionEditTasksFragmentToTasksFragment()
            findNavController().navigate(action)
        }
    }
    fun showDatePicker() {

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
        datePicker.show(parentFragmentManager, "DatePicker")
        datePicker.addOnPositiveButtonClickListener {
            datemilisec = it
            datePick = convertMillisecondsToReadableDate(it, "YYY, MM d ")
            binding?.date?.setText(datePick)


        }

    }
    private fun convertMillisecondsToReadableDate(
        dateMilliseconds: Long,
        datePattern: String
    ): String {
        val format = SimpleDateFormat(datePattern, Locale.getDefault())
        return format.format(Date(dateMilliseconds))

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentEditTasksBinding.inflate(inflater , container , false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.datepicker?.setOnClickListener {
            showDatePicker()
        }
        binding?.editButton?.setOnClickListener {
            edit()
        }
        binding?.editTitle?.setText(navArg.title)
        binding?.editDescription?.setText(navArg.description)
        binding?.date?.setText(navArg.date)
    }




}