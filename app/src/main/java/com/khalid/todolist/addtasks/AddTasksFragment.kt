package com.khalid.todolist.addtasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import com.khalid.todolist.R
import com.khalid.todolist.TodoListApplication
import com.khalid.todolist.databinding.FragmentAddTasksBinding
import com.khalid.todolist.databinding.FragmentTasksBinding
import com.khalid.todolist.datalayer.data.DataModel
import com.khalid.todolist.utils.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class AddTasksFragment : Fragment() {
    var datePick = ""
    var datemilisec: Long = 0
    private var _binding: FragmentAddTasksBinding? = null
    private val binding get() = _binding
    private val viewModel: AddViewModel by activityViewModels {
        ViewModelFactory((activity?.application as TodoListApplication).repository)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddTasksBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.datepicker?.setOnClickListener {
            showDatePicker()
        }
        binding?.floatingActionButton3?.setOnClickListener {
            addNewTask()
        }
    }

    private fun addNewTask() {
        if (isEntryValid()) {
            viewModel.addNewProduct(
                binding?.editTitle?.text.toString(),
                binding?.editDescription?.text.toString(),
                binding?.date?.text.toString()

            )
            val action = AddTasksFragmentDirections.actionAddTasksFragmentToTasksFragment()
            findNavController().navigate(action)
        }
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding?.editTitle?.text.toString(),
            binding?.editDescription?.text.toString(),
            binding?.date?.text.toString()
        )
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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

