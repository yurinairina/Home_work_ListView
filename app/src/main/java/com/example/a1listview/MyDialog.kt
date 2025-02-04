package com.example.a1listview
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
class MyDialog {
    companion object {
        fun createDialog(
            context: Context,
            adapter: ArrayAdapter<String>
        ): AdapterView.OnItemClickListener =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                //val user = adapter.getItem(position)
                val builder = AlertDialog.Builder(context)
                builder
                    .setTitle("Внимание")
                    .setMessage("Удалить данные?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setCancelable(true)
                    .setNegativeButton("Нет") { dialog, which ->
                        dialog.cancel()
                    }
                    .setPositiveButton("Да") { dialog, which ->
                        val note = adapter.getItem(position)
                        adapter.remove(note)
                        Toast.makeText(context, "Данные удалены:$note", Toast.LENGTH_LONG).show()
                    }.create()
                builder.show()
            }
    }
}


