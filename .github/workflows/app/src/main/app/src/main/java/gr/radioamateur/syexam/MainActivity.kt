package gr.radioamateur.syexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val RadioBlue = Color(0xFF0755A5)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF3F6FA)
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    var showInfo by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "RADIO AMATEUR",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = RadioBlue
        )

        Text(
            text = "ΕΞΕΤΑΣΕΙΣ SY",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(35.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "ΠΡΟΣΟΜΟΙΩΣΗ ΕΞΕΤΑΣΕΩΝ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp,
                    color = RadioBlue
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text("• 100 ερωτήσεις")
                Text("• 80 σωστές για επιτυχία")
                Text("• Άμεση διόρθωση απαντήσεων")
                Text("• Επεξήγηση σωστής απάντησης")
                Text("• Χωρίς επανάληψη ερωτήσεων στο ίδιο τεστ")
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = { showInfo = true },
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = RadioBlue
            )
        ) {
            Text("ΕΝΑΡΞΗ ΕΞΕΤΑΣΗΣ", fontSize = 17.sp)
        }

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedButton(
            onClick = { showInfo = true },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text("ΠΡΟΟΔΟΣ")
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Λειτουργία χωρίς σύνδεση στο Internet",
            fontSize = 13.sp,
            color = Color.Gray
        )
    }

    if (showInfo) {
        AlertDialog(
            onDismissRequest = { showInfo = false },
            title = { Text("Radio Amateur SY") },
            text = {
                Text("Η βάση ερωτήσεων και η λειτουργία εξετάσεων θα προστεθούν στα επόμενα βήματα.")
            },
            confirmButton = {
                TextButton(onClick = { showInfo = false }) {
                    Text("ΕΝΤΑΞΕΙ")
                }
            }
        )
    }
}
