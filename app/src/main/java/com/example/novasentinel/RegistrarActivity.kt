package com.example.novasentinel

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class RegistrarActivity : AppCompatActivity() {

    private lateinit var editTextFechaNacimiento: EditText
    private lateinit var editTextGenero: EditText
    private lateinit var calendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        editTextFechaNacimiento = findViewById(R.id.editTextFechaNacimiento)
        editTextGenero = findViewById(R.id.editTextGenero)

        // Inicializar el calendario con la fecha actual
        calendar = Calendar.getInstance()

        // Crear un OnClickListener para el EditText de Fecha de Nacimiento
        editTextFechaNacimiento.setOnClickListener {
            showDatePickerDialog()
        }

        // Crear un OnClickListener para el EditText de Género
        editTextGenero.setOnClickListener {
            showGenderSelectionDialog()
        }
    }

    private fun showDatePickerDialog() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        // Crear el DatePickerDialog con el tema personalizado
        val datePickerDialog = DatePickerDialog(
            this,
            R.style.DatePickerDialogTheme, // Usar el tema personalizado aquí
            DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                // Actualizar el EditText de Fecha de Nacimiento con la fecha seleccionada
                val fecha = "$dayOfMonth/${month + 1}/$year"
                editTextFechaNacimiento.setText(fecha)
            },
            year, month, dayOfMonth
        )

        datePickerDialog.show()
    }

    private fun showGenderSelectionDialog() {
        val genderOptions = arrayOf("Femenino", "Masculino", "Otro")

        val builder = AlertDialog.Builder(this, R.style.AlertDialogTheme) // Usar el estilo personalizado
        builder.setTitle("Seleccionar Género")
        builder.setItems(genderOptions) { dialog, which ->
            val selectedGender = genderOptions[which]
            editTextGenero.setText(selectedGender)
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
}




