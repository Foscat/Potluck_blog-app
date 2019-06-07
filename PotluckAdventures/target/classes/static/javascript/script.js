document.getElementById("rock").addEventListener("click", answerRock);
document.getElementById("paper").addEventListener("click", answerPaper);
document.getElementById("scissors").addEventListener("click", answerScissors);

document.getElementById("start").addEventListener("click", startGame);

var yourAnswer = null;

function answerRock(){
    console.log("Your answer: Rock")
    yourAnswer = "Rock"
    document.getElementById("myAnswer").innerHTML = ("Your answer ~ " + yourAnswer);
}

function answerPaper(){
    console.log("Your answer: Paper")
    yourAnswer = "Paper"
    document.getElementById("myAnswer").innerHTML = ("Your answer ~ " + yourAnswer);
}

function answerScissors(){
    console.log("Your answwer: Scissors")
    yourAnswer = "Scissors";
    document.getElementById("myAnswer").innerHTML = ("Your answer ~ " + yourAnswer);
}

function updateScores(){
    scoreCard = {won, lost, draw}
    console.log("Update score:", scoreCard);
    document.getElementById("scoreCard").innerHTML = ("Your scores: Wins~" + scoreCard.won + " Draws~" + scoreCard.draw + " Losses~" + scoreCard.lost);
}

var computerAnswers = ["Rock", "Paper", "Scissors"];
var chooseAnswer = Math.floor(Math.random()*3);
var won = 0;
var lost = 0;
var draw = 0;
var scoreCard = {won, lost, draw}

function startGame() {
    var answer = computerAnswers[chooseAnswer];
    console.log(answer);

    if(yourAnswer === answer){
        console.log("It's a draw")
        draw++
    }

    if (answer === "Rock"){
        if(yourAnswer === "Paper"){
            console.log("You win");
            won++
        }
        if(yourAnswer === "Scissors"){
            console.log("You lost");
            lost++
        }
    }
    if (answer === "Paper"){
        if(yourAnswer === "Scissors"){
            console.log("You win");
            won++
        }
        if(yourAnswer === "Rock"){
            console.log("You lost");
            lost++
        }
    }
    if (answer === "Scissors"){
        if(yourAnswer === "Rock"){
            console.log("You win");
            won++
        }
        if(yourAnswer === "Paper"){
            console.log("You lost");
            lost++
        }
    }
    chooseAnswer = Math.floor(Math.random()*3);
    console.log("Wins:" + won, "Losses: " + lost, "Draws: " + draw);
    updateScores();
}

