package com.example.wordle

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()
{
    private lateinit var wordToGuess : String
    private var tries = 0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startGame()
    }

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String
    {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }

    private fun startGame()
    {
        tries = 1
        wordToGuess = FourLetterWordList.getRandomFourLetterWord()

        val ansTxt = findViewById<TextView>( R.id.AnswerTxt )
        ansTxt.text = wordToGuess

        val btn = findViewById<Button>( R.id.GuessBtn )
        btn.setOnClickListener {
            Log.d(  "MyApp", "Button Working ")

            val inputTxt = findViewById<TextView>( R.id.WordTxt )
            val resultTxt = findViewById<TextView>( R.id.ResultTxt )
            val guessInput = findViewById<EditText>( R.id.GuessInput )

            var guess = guessInput.text.toString().uppercase()

            // hide keyboard
            val imm: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
            guessInput.text.clear()

            if ( guess.length < 4 )
            {
                Toast.makeText( this, "Guess length is too short", Toast.LENGTH_SHORT ).show()
            }
            else
            {
                var result = checkGuess( guess )

                var guessStr = StringBuilder( inputTxt.text.toString() + "Guess "+ tries.toString() +": "+  guess +"\n" ).toString()
                var resultStr = StringBuilder( resultTxt.text.toString() + "Result "+ tries.toString() +": "+  result +"\n" ).toString()

                inputTxt.text = guessStr
                resultTxt.text = resultStr

                if ( result == "OOOO")
                {
                    gameWin()
                }
                else if ( tries >= 4)
                {
                    gameLose()
                }
                else
                {
                    tries++
                }
            }
        }
    }

    private fun restartGame()
    {
        val btn = findViewById<Button>( R.id.GuessBtn )
        btn.setOnClickListener {
            val inputTxt = findViewById<TextView>( R.id.WordTxt )
            val resultTxt = findViewById<TextView>( R.id.ResultTxt )
            val ansTxt = findViewById<TextView>( R.id.AnswerTxt )

            ansTxt.visibility = View.INVISIBLE
            inputTxt.setText( "" )
            resultTxt.setText( "" )
            btn.setText( "Guess" )

            startGame()
        }
    }

    private fun gameWin()
    {
        gameEnd()
        Toast.makeText( this, "You Won!", Toast.LENGTH_SHORT ).show()
    }

    private fun gameLose()
    {
        gameEnd()
        Toast.makeText( this, "You Lose! Number of Tries Exceeded", Toast.LENGTH_SHORT ).show()
    }

    private fun gameEnd()
    {
        val ansTxt = findViewById<TextView>( R.id.AnswerTxt )
        val btn = findViewById<Button>( R.id.GuessBtn )

        ansTxt.visibility = View.VISIBLE
        btn.text = "Restart"

        btn.setOnClickListener {
            restartGame()
        }
    }
}