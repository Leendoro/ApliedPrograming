using System;

namespace TextAdventureGame
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to the Text Adventure Game!");
            Console.WriteLine("Choose your adventure:");
            Console.WriteLine("1. Forest Adventure");
            Console.WriteLine("2. Cave Adventure");

            Console.Write("Enter '1' or '2' to select your adventure: ");
            string adventureChoice = Console.ReadLine();
            AdventureGame adventure;

            if (adventureChoice == "1")
            {
                adventure = new ForestAdventure();
            }
            else if (adventureChoice == "2")
            {
                adventure = new CaveAdventure();
            }
            else
            {
                Console.WriteLine("Invalid choice. Exiting game.");
                return;
            }

            adventure.StartGame();
            adventure.MakeChoice();
        }
    }
}
