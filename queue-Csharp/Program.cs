using System.Linq;
using System.Security.Cryptography.X509Certificates;

namespace queue_Csharp
{
    internal class Program
    {
        public static void generateProcess(Queue<Process> priorityQueue, Queue<Process> normalQueue, int processAmount) 
        {
            Random generator = new Random();
            int processNumGenerated;

            // Generate the specified number of processes
            for (int i = 0; i < processAmount; i++)
            {
                processNumGenerated = generator.Next(0, 1001);
                switch (processNumGenerated)
                {
                    case 0:
                        // Remove from priority queue if the generated number is 0
                        Console.WriteLine("\nAttending: " + priorityQueue.Dequeue() + "\n");
                        break;

                    case 500:
                        // Remove from normal queue if the generated number is 500
                        Console.WriteLine("Attending: " + normalQueue.Dequeue());
                        break;

                    default:
                        // Insert process in the priority queue if the ID is less than 500
                        if (processNumGenerated < 500)
                        {
                            Process processTmp = new Process(processNumGenerated, "High priority process.");
                            // Add the process to the priority queue if not already present
                            if (!priorityQueue.Contains(processTmp))
                            {
                                priorityQueue.Enqueue(processTmp);
                                Console.WriteLine(processTmp);
                            }
                        }
                        // Insert process in the normal queue if the ID is greater than or equal to 500
                        else
                        {
                            Process processTmp = new Process(processNumGenerated, "Low priority process.");
                            // Add the process to the normal queue if not already present
                            if (!normalQueue.Contains(processTmp))
                            {
                                normalQueue.Enqueue (processTmp);
                                Console.WriteLine(processTmp);
                            }
                        }
                        break;
                }
            }
        }

        public static void showProcessNotAttended(Queue<Process> queue, String phrase)
        {

            Console.WriteLine("\n" + phrase);
            Console.WriteLine("Total Not Attended Process: " + queue.Count());

            // Display each process in the queue
            foreach (Process process in queue)
            {
                Console.WriteLine(process);
            }
        }

        static void Main(string[] args)
        {
            // Initialize the priority and normal queues
            Queue<Process> priorityQueue = new Queue<Process>();
            Queue<Process> normalQueue = new Queue<Process>();

            // Generate and distribute the processes between the two queues
            generateProcess(priorityQueue, normalQueue, 100);

            // Show the processes that have not been attended in both queues
            showProcessNotAttended(priorityQueue, "Priority Queue");
            showProcessNotAttended(normalQueue, "Normal Queue");
        }
    }
}