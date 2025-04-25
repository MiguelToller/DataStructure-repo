package Application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
	
	/**
     * Generates a specified number of random processes between 1 and 1000
     * and distributes them into two queues:
     * - A priority queue for processes with IDs less than 500
     * - A normal queue for processes with IDs greater than or equal to 500
     * 
     * The process is randomly generated, and each process is added to the
     * appropriate queue or attended (removed) based on the generated number.
     *
     * @param priorityQueue The queue that holds high-priority processes (<500)
     * @param normalQueue The queue that holds low-priority processes (>=500)
     * @param processAmount The number of processes to generate
     */

	public static void generateProcess(Queue<Process> priorityQueue, Queue<Process> normalQueue, int processAmount) {

		Random generator = new Random();
		int processNumGenerated;

		// Generate the specified number of processes
		for (int i = 0; i < processAmount; i++) {
			processNumGenerated = generator.nextInt(0, 1001);

			switch (processNumGenerated) {

			case 0:
				// Remove from priority queue if the generated number is 0
				System.out.println("Attending: " + priorityQueue.poll());
				break;

			case 500:
				// Remove from normal queue if the generated number is 500
				System.out.println("Attending: " + normalQueue.poll());
				break;

			default:
				// Insert process in the priority queue if the ID is less than 500
				if (processNumGenerated < 500) {
					Process processTmp = new Process(processNumGenerated, "High priority process.");
					// Add the process to the priority queue if not already present
					if (!priorityQueue.contains(processTmp)) {
						priorityQueue.offer(processTmp);
						System.out.println(processTmp);
					}
				}
				// Insert process in the normal queue if the ID is greater than or equal to 500
				else {
					Process processTmp = new Process(processNumGenerated, "Low priority process.");
					// Add the process to the normal queue if not already present
					if (!normalQueue.contains(processTmp)) {
						normalQueue.offer(processTmp);
						System.out.println(processTmp);
					}
				}
				break;
			}
		}
	}
	
	 /**
     * Displays all processes that are in the given queue and have not been attended yet.
     * 
     * @param queue The queue containing the processes to be displayed (either normal or priority)
     * @param phrase A description or title to be displayed before showing the queue
     */

	public static void showProcessNotAttended(Queue<Process> queue, String phrase) {

		System.out.println("\n"+phrase);
		System.out.println("Total Not Attended Process: " + queue.size());
		
		// Display each process in the queue
		for (Process process : queue) {
			System.out.println(process);
		}
	}

	public static void main(String[] args) {

		// Initialize the priority and normal queues
		Queue<Process> priorityQueue = new LinkedList<>();
		Queue<Process> normalQueue = new LinkedList<>();

		// Generate and distribute the processes between the two queues
		generateProcess(priorityQueue, normalQueue, 1000);
		
		// Show the processes that have not been attended in both queues
		showProcessNotAttended(priorityQueue, "Priority Queue");
		showProcessNotAttended(normalQueue, "Normal Queue");
	}
}
