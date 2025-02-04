package com.example.a1listview

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


//class MyDialog: DialogFragment() {
//    private var removable: Removable? = null
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        removable = context as Removable?
//    }
//       @SuppressLint("StringFormatInvalid")
//       override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val note =requireArguments().getString("note")
//        val builder = AlertDialog.Builder(
//            requireActivity()
//        )
//        return builder
//            .setTitle("Внимание")
//            .setMessage("Удалить $note")
//            .setIcon(R.drawable.ic_delete)
//               .setPositiveButton("Да") { dialog, which->
//                removable?.remove(note.toString())
//                //Toast.makeText(context, getString(R.string.user_deleted_text,note), Toast.LENGTH_SHORT).show()
//            }
//            .setNegativeButton("Нет", null)
//            .create()
//
//    }
//
//}