package br.com.colletor.garbage.acme

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset


class ColletorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colletor)

        val btnSchedule: Button = findViewById(R.id.buttonSchedule)

        btnSchedule.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,ScheduleActivity::class.java)
            startActivity(intent)
        })

        val listViewSouth: ListView = findViewById(R.id.listViewSouth)
        val listViewNorth: ListView = findViewById(R.id.listViewNorth)
        val listViewEast: ListView = findViewById(R.id.listViewEast)
        val listViewWest: ListView = findViewById(R.id.listViewWest)
        val listViewCenter: ListView = findViewById(R.id.listViewCenter)

        // Lista os registros por região
        // Os dados também podem ser consumidos via API REST
        // Para exibição dinâmica no APP

        val southZone = arrayOf(
            "21/11/2022 - Segunda-feira - 10h",
            "23/11/2022 - Quarta-feira - 19h",
            "25/11/2022 - Sexta-feira - 9h"
        )

        val northZone = arrayOf(
            "21/11/2022 - Segunda-feira - 15h",
            "23/11/2022 - Quarta-feira - 12h",
            "25/11/2022 - Sexta-feira - 14h"
        )

        val eastZone = arrayOf(
            "21/11/2022 - Segunda-feira - 13h",
            "23/11/2022 - Quarta-feira - 14h",
            "25/11/2022 - Sexta-feira - 15h"
        )

        val westZone = arrayOf(
            "21/11/2022 - Segunda-feira - 18h",
            "23/11/2022 - Quarta-feira - 10h",
            "25/11/2022 - Sexta-feira - 19h"
        )

        val centerZone = arrayOf(
            "21/11/2022 - Segunda-feira - 10h",
            "22/11/2022 - Terça-feira - 10h",
            "23/11/2022 - Sexta-feira - 10h"
        )

        val adapterViewSouth: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, southZone)
        listViewSouth.setAdapter(adapterViewSouth);

        val adapterViewNorth: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, northZone)
        listViewNorth.setAdapter(adapterViewNorth);

        val adapterViewEast: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eastZone)
        listViewEast.setAdapter(adapterViewEast);

        val adapterViewWest: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, westZone)
        listViewWest.setAdapter(adapterViewWest);

        val adapterViewCenter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, centerZone)
        listViewCenter.setAdapter(adapterViewCenter);

    }

    fun saveDataFile(filename: String, data: String) {

        try {
            val fs = openFileOutput(filename,Context.MODE_PRIVATE);

            fs.write(data.toByteArray())
            fs.close()
        } catch (e: FileNotFoundException){
            Log.i("saveDataFile","FileNotFoundException")
        } catch (e: IOException){
            Log.i("saveDataFile","IOException")
        }
    }

    fun restoreDataFromFile(filename: String): String {

        try{

            val fi = openFileInput(filename)
            val data = fi.readBytes()

            fi.close()

            data.toString()

            return data.toString(Charset.defaultCharset())
        } catch (e: FileNotFoundException){
            return ""
        } catch (e: IOException){
            return ""
        }

    }
}