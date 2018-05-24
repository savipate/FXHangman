package server;

import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.*;

public class Server {

    private static ServerSocket serverSocket;
    private static DataInputStream inputFromClient;
    private static DataOutputStream outputToClient;
    private static final int PORTNUMBER = 7777;

    static String mysteryWord;
    static StringBuilder currentGuess;
    static ArrayList<Character> previousGuesses = new ArrayList<>();

    static int maxTries = 10;
    static int currentTry = 0;
    static int wins = 0;
    static int losses = 0;
    static boolean doYouWantToPlay;
    static boolean gameOver;
    private static String lossCount;
    private static String winCount;

    static ArrayList<String> dictionary = new ArrayList<String>();
    private static FileReader fileReader;
    private static BufferedReader bufferedFileReader;
    private static final String fileName = "src/server/wordList.txt";


    public static void main(String[] args) throws Exception {

//        System.out.println("Server Started");
        serverSocket = new ServerSocket(PORTNUMBER);
        Socket socket = serverSocket.accept();
//        System.out.println("Connection from " + socket.getInetAddress());
        inputFromClient = new DataInputStream(socket.getInputStream());
        outputToClient = new DataOutputStream(socket.getOutputStream());

        while(true) {

            // Allows for multiple games
            doYouWantToPlay = inputFromClient.readBoolean();


            while (doYouWantToPlay) {
                // Setting up the game

                //gets words from file
                initializeStreams();
                //chooses random word
                mysteryWord = pickWord();
                mysteryWord = mysteryWord.toUpperCase();
                //creates word with blanks
                currentGuess = initializeCurrentGuess();

                //amount of wrong answers
                outputToClient.writeInt(currentTry);
                outputToClient.flush();
                //word with blanks
                outputToClient.writeUTF(String.valueOf(currentGuess));
                outputToClient.flush();

//                System.out.println("Game Initiated");
                do {

                    System.out.println(getFormalCurrentGuess());
                    System.out.print(mysteryWord + "\n");

                    // Get the guess
//                    System.out.println("Enter a character that you think is in the word");
                    char guess = inputFromClient.readUTF().toUpperCase().charAt(0);

                    //System.out.println(guess);

                    // Check if the character is in word and replaces blanks

                    //Bad guess until verified
                    boolean isItAGoodGuess = false;
                    //keeps track of letters used
                    previousGuesses.add(guess);
                    for (int i = 0; i < mysteryWord.length(); i++) {
                        if (mysteryWord.charAt(i) == guess) {
                            currentGuess.setCharAt(i * 2, guess);
                            isItAGoodGuess = true;
                        }
                    }
                    if (!isItAGoodGuess) {
                        currentTry++;
                    }

                    //Sends amount of wrong answers
                    outputToClient.writeInt(currentTry);
                    outputToClient.flush();
                    //word with blanks
                    outputToClient.writeUTF(String.valueOf(currentGuess));
                    outputToClient.flush();

                    if (didWeWin()) {
                        System.out.println();
//                        System.out.println("Congrats! You won! You guessed the right word!");
                        wins++;
                        winCount = "Wins: " + wins;
                        currentTry = 0;
                        outputToClient.writeUTF(winCount);
                        outputToClient.flush();
                        outputToClient.flush();
                        outputToClient.writeUTF(lossCount);
                        gameOver = true;
                    } else if (didWeLose()) {
                        System.out.println();
//                        System.out.println("Sorry, you lost. You spent all 10 tries. "
//                                + "The word was " + mysteryWord + ".");
                        losses++;
                        lossCount = "Loss: " + losses;
                        currentTry = 0;
                        outputToClient.writeUTF(winCount);
                        outputToClient.flush();
                        outputToClient.writeUTF(lossCount);
                        outputToClient.flush();
                        gameOver = true;
                    }
                    else{
                        winCount = "Wins: " + wins;
                        lossCount = "Loss: " + losses;
                        outputToClient.writeUTF(winCount);
                        outputToClient.flush();
                        outputToClient.writeUTF(lossCount);
                        outputToClient.flush();
                        gameOver = false;
                    }
//                    System.out.println("Wins: "+wins + "\nLosses: " + losses);
                    outputToClient.writeBoolean(gameOver);
                    outputToClient.flush();

                }
                while (!gameOver); // Keep playing until the game is over
//                System.out.println("game ended");
                doYouWantToPlay = true;
            }
        }
    }


    //reads in words from text file
    public static void initializeStreams() throws IOException {
        try {

            String line;
            File inFile = new File(fileName);
            String absPath = inFile.getAbsolutePath();
            fileReader = new FileReader(absPath);
            bufferedFileReader = new BufferedReader(fileReader);

            while ((line = bufferedFileReader.readLine()) != null) {
                //sees if line contains whats in regex since we do not want those words
                if (line.matches(".*[-,'.&1234567890/].*")) {
                    continue;
                }
                dictionary.add(line);
            }
            fileReader.close();
            bufferedFileReader.close();
        } catch (Exception e) {
            System.out.println("Couldn't find/read file: " + fileReader);
            System.out.println("Error message: " + e.getMessage());
        }
    }

    //gets random word from dictionary
    public static String pickWord() {
        Random rand = new Random();
        int wordIndex = Math.abs(rand.nextInt()) % dictionary.size();
        return dictionary.get(wordIndex).toUpperCase();
    }

    // _ A _ _ _ _ _ _

    //takes word and converts to string with blanks in between characters
    public static StringBuilder initializeCurrentGuess() {
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < mysteryWord.length() * 2; i++) {
            if (i % 2 == 0) {
                current.append("_");
            } else {
                current.append(" ");
            }
        }
        return current;
    }

    // _ _ A _ _ B
    public static String getFormalCurrentGuess() {
        return "Current Guess: " + currentGuess.toString();
    }


    //counter of tries is 10+
    public static boolean didWeLose() {
        return currentTry >= maxTries;
    }

    //checks to see if player word and computer word match
    public static boolean didWeWin() {
        String guess = getCondensedCurrentGuess();
        return guess.equals(mysteryWord);
    }

    //Removes all spaces added to word
    public static String getCondensedCurrentGuess() {
        String guess = currentGuess.toString();
        return guess.replace(" ", "");
    }


    public static boolean isGuessedAlready(char guess) {
        return previousGuesses.contains(guess);
    }

}

