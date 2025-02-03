package com.example.a1listview

import android.R.color.black
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.graphics.red
import java.sql.Array
class MainActivity : AppCompatActivity() {
    val notes: MutableList<String> = mutableListOf()
    //схема
    private lateinit var listView: ListView
    private lateinit var savedBTN: Button
    private lateinit var input_nameET: EditText //вводим Имя
    private lateinit var input_ageET: EditText //вводим Возраст
    private lateinit var toolbarMain: Toolbar
    @SuppressLint("ResourceAsColor", "RestrictedApi", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//схема= ID
        listView = findViewById(R.id.listView) //Cписок
        savedBTN = findViewById(R.id.savedBTN)
        input_nameET = findViewById(R.id.input_nameET)
        input_ageET = findViewById(R.id.input_ageET)
        toolbarMain = findViewById(R.id.toolbarMain)//Тулбар
//toolbar
        title = "Каталог пользователей"
        toolbarMain.subtitle = "Версия 1.0"
        toolbarMain.setLogo(R.drawable.ic_launcher_foreground)
        setSupportActionBar(toolbarMain)
//адаптер ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notes)
        listView.adapter = adapter

//        Параметры parent, v, position, id в Android означают следующее:
//        parent — нажатый элемент AdapterView (в роли которого в данном случае выступает элемент ListView);
//        view — нажатый виджет внутри AdapterView;
//        position — индекс нажатого виджета внутри AdapterView;
//        id — идентификатор строки нажатого элемента.

        listView.onItemClickListener =  //вывод списка
            AdapterView.OnItemClickListener { parent, v, position, id ->
                val note = adapter.getItem(position)
//Метод adapter.getItem(position) в Android означает, что он возвращает элемент данных на определённой позиции.
                adapter.remove(note) //удаление позиции в списке пр нажатии
                Toast.makeText(this, "Данные удалены:$note", Toast.LENGTH_LONG).show()
            }
//кнопка сохранить
        savedBTN.setOnClickListener {
            val user = User(input_nameET.text.toString(), input_ageET.text.toString().toIntOrNull() ?: 0)
            notes.add(user.toString())//добавляем данные
            adapter.notifyDataSetChanged()
 //Метод adapter.notifyDataSetChanged() в Android Studio уведомляет список
            // об изменении данных для обновления списка на экране.
            input_nameET.text.clear() //очищение полей при сохранении
            input_ageET.text.clear()
            Toast.makeText(this, "Пользователь ${user.name} добавлен", Toast.LENGTH_SHORT).show()
        }
    }
    // МЕНЮ
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.context_menu, menu)
        return true
    }
    // МЕНЮ выход
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.context_menuMain) {
            Toast.makeText(this, getString(R.string.exsit_text), Toast.LENGTH_LONG).show()
            finish() //всплывающее сообщение
        }
        return super.onOptionsItemSelected(item)
        //Метод onOptionsItemSelected в Android
    // вызывается при нажатии пункта меню.
    // Он определяет, какой пункт меню был нажат.
    }
}

