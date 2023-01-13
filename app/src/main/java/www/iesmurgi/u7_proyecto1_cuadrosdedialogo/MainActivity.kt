package www.iesmurgi.u7_proyecto1_cuadrosdedialogo

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import www.iesmurgi.u7_proyecto1_cuadrosdedialogo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        //Asignamos y creamos variables a usar
        val boton = binding.btLista
        val boton2 = binding.btBoton
        val items = arrayOf("Item 1", "Item 2", "Item 3")

        //Boton 1 muestra lo que pulsamos en la lista
        boton.setOnClickListener {

            //Creamos el builder
            val builder = AlertDialog.Builder(this)

            //Titulo e icono
            builder.setTitle("Alerta diálogo con listado").setIcon(R.drawable.ic_action_name).setItems(items,
                DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this, items[which], Toast.LENGTH_SHORT).show()
                })

            //Mostramos el dialogo
            val dialog = builder.create()
            dialog.show()
        }

        //Boton 2 muestra el dialogo con botones
        boton2.setOnClickListener {

            //Creamos el builder
            val builder = AlertDialog.Builder(this)

            //Titulo e icono
            builder.setTitle("Alerta diálogo con botones").setIcon(R.drawable.ic_action_name)

            //Le ponemos boton positivo
            builder.setPositiveButton("Positivo") { dialog, which ->
                Toast.makeText(this, "Boton positivo", Toast.LENGTH_SHORT).show()
            }
            //Le ponemos boton negatvio
            builder.setNegativeButton("Negativo") { dialog, which ->
                Toast.makeText(this, "Botón negativo", Toast.LENGTH_SHORT).show()
            }

            //Le ponemos el boton neutral
            builder.setNeutralButton("Neutral") { dialog, which ->
                Toast.makeText(this, "Botón neutral", Toast.LENGTH_SHORT).show()
            }

            val dialog = builder.create()

            //Mostramos los botones con diferentes colores
            dialog.setOnShowListener {
                val btPositivo = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                btPositivo.setTextColor(ContextCompat.getColor(this, R.color.verde))

                val btNegativo = dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
                btNegativo.setTextColor(ContextCompat.getColor(this, R.color.rojo))

                val btNeutral = dialog.getButton(AlertDialog.BUTTON_NEUTRAL)
                btNeutral.setTextColor(ContextCompat.getColor(this, R.color.amarillo))
            }
            //Mostramos el dialogo
            dialog.show()
        }
    }
}