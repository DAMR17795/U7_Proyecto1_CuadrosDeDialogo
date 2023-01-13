package www.iesmurgi.u7_proyecto1_cuadrosdedialogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import www.iesmurgi.u7_proyecto1_cuadrosdedialogo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val boton = findViewById<Button>(R.id.btn)
        val boton2 = findViewById<Button>(R.id.btn2)
        var selectedItemIndex = 0;
        val items = arrayOf("valorant", "lol", "fifa", "csgo")
        var selectedItem = items[selectedItemIndex]

        boton.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("List dialog")

            //builder.setIcon(R.drawable.simbol)

            builder.setSingleChoiceItems(items, selectedItemIndex) { dialog, which ->
                selectedItemIndex = which
                selectedItem = items[which]
                Toast.makeText(this, items[which], Toast.LENGTH_SHORT).show()
            }

            val dialog = builder.create()
            dialog.show()
        }

        boton2.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Buttons dialog")

            //builder.setIcon(R.drawable.simbol)

            builder.setPositiveButton("Ok") { dialog, which ->


                Toast.makeText(this, "Has pulsado un boton positivo", Toast.LENGTH_SHORT).show()

            }

            builder.setNegativeButton("Cancel") { dialog, which ->

                Toast.makeText(this, "Has pulsado un boton negativo", Toast.LENGTH_SHORT).show()

            }

            val dialog = builder.create()
            dialog.setOnShowListener {
                val positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                positiveButton.setTextColor(ContextCompat.getColor(this, R.color.verde))

                val negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
                negativeButton.setTextColor(ContextCompat.getColor(this, R.color.rojo))
            }

            dialog.show()

        }

    }
}