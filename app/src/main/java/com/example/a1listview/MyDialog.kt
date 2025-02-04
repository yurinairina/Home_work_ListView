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
                val user = adapter.getItem(position)
                //Метод adapter.getItem(position) в Android означает, что он возвращает элемент данных на определённой позиции.
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