using System;

namespace TextAdventureGame
{
    public class ForestAdventure : AdventureGame
    {
        public override void StartGame()
        {
            Console.WriteLine("You find yourself at the edge of a dark forest.");
            Console.WriteLine("Will you enter the forest or stay at the edge?");
        }

        public override void MakeChoice()
        {
            Console.Write("Enter '1' to enter the forest or '2' to stay at the edge: ");
            string choice = Console.ReadLine();

            if (choice == "1")
            {
                Console.WriteLine("You venture into the forest and discover a hidden treasure!");
                EndGame("Congratulations! You are victorious.");
            }
            else if (choice == "2")
            {
                Console.WriteLine("You decide to stay safe, but miss out on an adventure.");
                EndGame("Game Over. You played it safe.");
            }
            else
            {
                Console.WriteLine("Invalid choice! Try again fool.");
                MakeChoice();
            }
        }
    }
}