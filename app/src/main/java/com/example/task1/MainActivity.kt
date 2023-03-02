package com.example.task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
//import com.example.task1.databinding.ActivityMainBinding
import com.example.task1.databinding.ActivitySignupBinding
import com.example.task1.screen.HomeScreen
import com.example.task1.screen.HomeViewModel
import com.google.firebase.auth.FirebaseAuth
import com.example.task1.theme.MongoDemoTheme

class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth1: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MongoDemoTheme {
                val viewModel: HomeViewModel = hiltViewModel()
                val data by viewModel.data
                HomeScreen(
                    data = data,
                    filtered = viewModel.filtered.value,
                    name = viewModel.name.value,
                    objectId = viewModel.objectId.value,
                    onNameChanged = { viewModel.updateName(name = it) },
                    onObjectIdChanged = { viewModel.updateObjectId(id = it) },
                    onInsertClicked = { viewModel.insertPerson() },
                    onUpdateClicked = { viewModel.updatePerson() },
                    onDeleteClicked = { viewModel.deletePerson() },
                    onFilterClicked = { viewModel.filterData() }
                )
            }
        }
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        firebaseAuth1 = FirebaseAuth.getInstance()
//       binding.button.setOnClickListener{
           firebaseAuth1.signOut()
           val intent = Intent(this, SigninActivity::class.java)
           startActivity(intent)
//       }
    }
}