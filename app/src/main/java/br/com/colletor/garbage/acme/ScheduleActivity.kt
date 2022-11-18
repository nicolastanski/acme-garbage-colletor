package br.com.colletor.garbage.acme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class ScheduleActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_schedule)

            val btnSaveSchedule: Button = findViewById(R.id.btnSaveSchedule)
            val editTextLocation: EditText = findViewById(R.id.editTextLocation)
            val editTextQuantity: EditText = findViewById(R.id.editTextQuantity)
            val editTextWeight: EditText = findViewById(R.id.editTextWeight)
            val listDays: Spinner = findViewById(R.id.listDays)
            val listHours: Spinner = findViewById(R.id.listHours)

            btnSaveSchedule.setOnClickListener(View.OnClickListener {

                val db = DatabaseManager(this, "schedules")

                db.insertSchedule(
                    1,
                    editTextLocation.text.toString(),
                    editTextQuantity.text.toString(),
                    editTextWeight.text.toString(),
                    listDays.selectedItem.toString(),
                    listHours.selectedItem.toString()
                )

                Toast.makeText(this,"Agendamento salvo com sucesso",Toast.LENGTH_SHORT).show()

            })

        }
}


//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val btnSalvar: Button = findViewById(R.id.btnSalvar)
//        val btnExibir: Button = findViewById(R.id.btnExibir)
//        val txtNome: TextView = findViewById(R.id.txtNome)
//        val listTratamento: Spinner = findViewById(R.id.listTratamento)
//
//
//        btnSalvar.setOnClickListener(View.OnClickListener {
//
//            /*val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
//            val editor = saudacaoPersistencia.edit()
//
//            editor.putString("nome",txtNome.text.toString())
//            editor.putString("tratamento",listTratamento.selectedItem.toString())
//            editor.apply()*/
//
//
//            val data = txtNome.text.toString() + ":" + listTratamento.selectedItem.toString()
//            gravaDadoArquivo("saudacao",data)
//
//
//            Toast.makeText(this,"Salvo com Sucesso",Toast.LENGTH_SHORT).show()
//
//        })
//
//        btnExibir.setOnClickListener(View.OnClickListener {
//
//            val intent = Intent(this,SaudacaoActivity::class.java)
//            startActivity(intent)
//        })
//    }
//
//
//    fun gravaDadoArquivo(filename: String, data: String) {
//
//        try {
//            val fs = openFileOutput(filename,Context.MODE_PRIVATE);
//
//            fs.write(data.toByteArray())
//            fs.close()
//        }
//        catch (e: FileNotFoundException){
//            Log.i("gravaDadoArquivo","FileNotFoundException")
//        }
//        catch (e: IOException){
//            Log.i("gravaDadoArquivo","IOException")
//        }
//    }
//}


