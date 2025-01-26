using System;

namespace TextAdventureGame
{
    public class CaveAdventure : AdventureGame
    {
        public override void StartGame()
        {
            Console.WriteLine("You are standing in front of a mysterious cave.");
            Console.WriteLine("Will you explore the cave or turn back?");
        }

        public override void MakeChoice()
        {
            Console.Write("Enter '1' to explore the cave or '2' to turn back: ");
            string choice = Console.ReadLine();

            if (choice == "1")
            {
                Console.WriteLine("You enter the cave and encounter a sleeping dragon!");
                EndGame("The dragon awakens and decides to befriend you. You're a hero!");
            }
            else if (choice == "2")
            {
                Console.WriteLine("You turn back and avoid potential danger, but gain nothing.");
                EndGame("Game Over. No risk, no reward.");
            }
            else
            {
                Console.WriteLine("Invalid choice! Try again.");
                MakeChoice();
            }
        }
    }
}