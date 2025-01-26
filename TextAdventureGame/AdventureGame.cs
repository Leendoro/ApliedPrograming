using System;

namespace TextAdventureGame
{
    public abstract class AdventureGame
    {
        public abstract void StartGame();
        public abstract void MakeChoice();
        
        public void EndGame(string outcome)
        {
            Console.WriteLine(outcome);
            Console.WriteLine("Thank you for playing!");
        }
    }
}