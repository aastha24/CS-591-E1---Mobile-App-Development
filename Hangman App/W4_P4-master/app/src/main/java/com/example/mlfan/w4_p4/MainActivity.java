package com.example.mlfan.w4_p4;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    // initialize variables
    // letter clicked by user to be added t game
    public TextView chosenLetter;
    // dictionary of words to select from for hangman game word
    ArrayList<String> dictionary = new ArrayList<String>();
    // the word to be guessed for the game
    String newWord;
    // individual letters in newWord, as a character array
    char[] partsCharArray;
    // individual letters in newWord, as a String array
    String[] partsStringArray;
    // the word to be guessed for the game
    // starts as a string of dashes and ends as newWord
    public TextView word;
    // the image display of the hangman gallows, changes as the user guesses incorrect letters
    public ImageView gallowsImage;
    // array of images to  be displayed as the user guesses incirrectly
    private int[] imageArray = {
            R.drawable.hang0,
            R.drawable.hang1,
            R.drawable.hang2,
            R.drawable.hang3,
            R.drawable.hang4,
            R.drawable.hang5,
            R.drawable.hang6,

    };
    // the number of times the user guesses an incorrect letter
    // determines when the gallowsImage is changed and when the user loses
    int incorrectGuesses =0;
    // number of the user gusses a correct letter
    // determines when the user wins
    // since the current version of the game only includes 5-letter words, the user wins when numLetters = 5
    int numLetters = 0;
    // the hint displayed in landscape mode
    TextView hint;
    // the "dictionary" of hints to be displayed for each newWord
    ArrayList<String> hintList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get reference to the TextView to display the word as the user plays the game
        word = (TextView) findViewById(R.id.txtWord);

        // Add words to the dictionary
        // for now we will only use 5-letter words
        dictionary.add("SHAKE");
        dictionary.add("WHALE");
        dictionary.add("SHARK");
        dictionary.add("FRIES");
        dictionary.add("HONEY");
        dictionary.add("GOATS");
        dictionary.add("HORSE");
        dictionary.add("CRABS");
        dictionary.add("STEAK");
        dictionary.add("BIRDS");

        // randomly pick an index in the dictionary
        Random random = new Random();
        int wordIndex = random.nextInt(10);

        // get the word at that randomly chosen index
        newWord = dictionary.get(wordIndex);
        Log.v("newWord",newWord);
        // split the word into its individual letters
        partsCharArray = newWord.toCharArray();
        partsStringArray = newWord.split("");

        // get the reference to the Image View to display the gallows image as tthe user plays the game
        gallowsImage = (ImageView) findViewById(R.id.imgGallows);

        // get the reference to the Text View to display the hint  in landscape mode
        hint = (TextView) findViewById(R.id.txtHint);

        // create the "dictionary" of hints that corresponds to each word in the dictionary
        hintList.add("Food");
        hintList.add("Sea Aninmal");
        hintList.add("Sea Animal");
        hintList.add("Food");
        hintList.add("Food");
        hintList.add("Farm Animals");
        hintList.add("Farm Animal");
        hintList.add("Sea Animal");
        hintList.add("Food");
        hintList.add("Flying Animals");
        // detect if the display is in landscape mode
        int orientation = this.getResources().getConfiguration().orientation;
        // if it is, display the hint
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            String hintWord = hintList.get(wordIndex);
            hint.setText(hintWord);
        }
    }

    // method called after each letter is clicked
    public void onLetterClick(View v) {
        // get the id of the letter that was clicked
        int id = v.getId();
        Log.v("Id From Getid",Integer.toString(id));
        // get the reference to the chosen letter
        chosenLetter = (TextView) findViewById(id);
        // get the letter that corresponds chosen letter as a String
        String getChar = (String) chosenLetter.getText();
        Log.v("chosenLetter",getChar);
        // get the current state of the worrd to guessed in the game
        // if it is the beginning, it is all underscores
        // if it is in the middle off gameplay, it will be some underscores and some letters
        String currentText = (String) word.getText();
        Log.v("chosenLetter",currentText);
        // get a LIST of individual letter in the word as STRINGS
        // lists are better for testing for set membership
        List<String> list = Arrays.asList(partsStringArray);


        // test for set membership -- i.e. check if newWord contains the letter clicked
        // if the user guessed a CORRECT letter
        if (list.contains(getChar)){
            // get the position of the letter in newWord
            int index = list.indexOf(getChar);
            Log.v("index",Integer.toString(index));
            // get the appropriate letter from the CHARACTER array
            // we must adjust the index from the list to the array with (index - 1)
            char letter = partsCharArray[index-1];
            // the Text View that displays the  word to the user is a single Text View
            // when the app is initialized and the user sees dashes to represent the word, it is a string with
            //"_ _ _ _ _", which is a combination of strings AND underscores that make the word twice as long
            // as it actually is
            // so we need to multiple the index of the character in the word by 2 to place it in the
            // appropriate location in the Text View
            int displayIndex = (index-1) * 2;
            // create a String Builder object with String from currentText
            // this allows us to manipulate the String that is displayed
            StringBuilder newText = new StringBuilder(currentText);
            // put the letter in the right place in the word
            newText.setCharAt(displayIndex, letter);
            // create a string with the word with the new letter
            String wordWithNewLetter = newText.toString();
            Log.v("Word with new letter", wordWithNewLetter);
            // place the word with the new letter in the Text View so the user sees the letter they guessed correctly
            word.setText(wordWithNewLetter);
            // update the number of correct letter guessed by 1
            numLetters = numLetters + 1;
            // if numLetters = 5, then the user has guessed all letters currectly and the user wins
            if (numLetters == 5){
                winDialog();
            }
        // if the user guesses an INCORRECT letter
        }else {
            // update the number of incorrect guesses by 1
            incorrectGuesses = incorrectGuesses + 1;
            // if the user has not lost already, update the gallows image
            changeGallowsImage(incorrectGuesses);
        }

        // change the background color of the letter that the user guessed so the user knows not to guess it aain
        // change the background color regardless if the guess was correct or incorrect
        v.setBackgroundColor(Color.GREEN);
    }

    // method to change the image displayed to show the user how many times they have guessed incorrectly
    public void changeGallowsImage(int count) {
        // get the image that corresponds to the number  of incorrect guesses the user had made
        Drawable d = getResources().getDrawable(imageArray[count]);
        // place the image corresponding to the number of incorrect guesses in the imageView
        gallowsImage.setImageDrawable(d);
        // if the user has made 6 incorrect guesses, they lose
        if(count == 6) {
            loseDialog();
        }
    }

    // dialog box to tell the loser they have lost
    public void loseDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("You Lose! :(");
        alert.setMessage("Play again?");
        PlayDialogue playAgain = new PlayDialogue();
        alert.setPositiveButton("YES", playAgain);
        alert.setNegativeButton("NO", playAgain);
        alert.show();
    }

    // dialog box to tell the loser they have lost
    public void winDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("You win! Good job!");
        alert.setMessage("Play again?");
        PlayDialogue playAgain = new PlayDialogue();
        alert.setPositiveButton("YES", playAgain);
        alert.setNegativeButton("NO", playAgain);
        alert.show();
    }

    // interface to allow the user to either choose to play again or close the app
    private class PlayDialogue implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int id) {
            // if the user selects that they want to play again, restart the game
            if (id == -1){
                Intent intent = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            // if the user selects that they do NOt want to play again, close the app
            } else if (id == -2){
                MainActivity.this.finish();
                System.exit(0);
            }
        }
    }
}