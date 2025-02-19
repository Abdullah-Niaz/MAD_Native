package com.example.addtwonumbers

import android.R.attr.text
import android.os.Bundle
// base class for activity in compose
import androidx.activity.ComponentActivity
// sets the UI using compose instead of XML
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
//allow you preview the UI inside the Android Studio
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.addtwonumbers.ui.theme.AddTwoNumbersTheme


//MainActivity is the main entry point of the app.
//onCreate() is called when the activity starts.
//setContent {} sets the Compose UI (CalculatorUI()) inside the theme.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddTwoNumbersTheme {
                CalculatorUI()
            }
        }
    }
}

// this decorator build the UI in compose
@Composable
fun CalculatorUI() {
//    set state variables
//    input1, input2, and result store user inputs and the sum.
//    remember { mutableStateOf("") } → Keeps track of UI state.
    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

//    The UI uses a column (a vertical layout container)

    Column(

        modifier = Modifier
            .fillMaxSize() // UI takes full screen width & height
            .padding(16.dp), // adds space around the UI
        verticalArrangement = Arrangement.Center // Centers everything vertically
    ) {
        OutlinedTextField( // a input text field
            value = input1, // the field show input1
            onValueChange = { input1 = it }, // updates input1 when user types
            label = { Text("Enter First No") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number), // open numberic keyboard
            modifier = Modifier.fillMaxWidth() // makes the field take full width
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
//            Displays + in the center between the two input fields.
            text = "+",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = input2,
            onValueChange = { input2 = it },
            label = { Text("Enter Second No") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { // runs code when button is clicked
//                Convert text to double (if empty, use 0.0)
                val num1 = input1.toDoubleOrNull() ?: 0.0
                val num2 = input2.toDoubleOrNull() ?: 0.0
//                add the numbers & updated result
                result = (num1 + num2).toString()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            // Button is labeled
            Text("Abdullah")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = result,
            onValueChange = {},
            label = { Text("Result") },
            readOnly = true, // user can't edit it
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    AddTwoNumbersTheme {
        CalculatorUI()
    }
}
