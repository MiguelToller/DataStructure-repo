from Process import Process
from queue import Queue
import random

def generate_process(priority_queue, normal_queue, process_amount):
    """
    Generates a specified number of random processes between 1 and 1000
    and distributes them into two queues:
    - A priority queue for processes with IDs less than 500
    - A normal queue for processes with IDs greater than or equal to 500

    The process is randomly generated, and each process is added to the
    appropriate queue or attended (removed) based on the generated number.

    Args:
        priority_queue: The queue that holds high-priority processes (<500)
        normal_queue: The queue that holds low-priority processes (>=500)
        process_amount: The number of processes to generate
    """
    # Generate the specified number of processes
    for i in range(process_amount):
        process_num_generated = random.randint(0, 1000)

        if process_num_generated == 0:
            # Remove from priority queue if the generated number is 0
            process = priority_queue.get() if not priority_queue.empty() else None
            print(f"\nAttending: {process}\n")
        elif process_num_generated == 500:
            # Remove from normal queue if the generated number is 500
            process = normal_queue.get() if not normal_queue.empty() else None
            print(f"\nAttending: {process}\n")
        else:
            # Insert process in the priority queue if the ID is less than 500
            if process_num_generated < 500:
                process_tmp = Process(process_num_generated, "High priority process.")
                # Add the process to the priority queue if not already present
                if process_tmp not in list(priority_queue.queue):
                    priority_queue.put(process_tmp)
                    print(process_tmp)
            # Insert process in the normal queue if the ID is greater than or equal to 500
            else:
                process_tmp = Process(process_num_generated, "Low priority process.")
                # Add the process to the normal queue if not already present
                if process_tmp not in list(normal_queue.queue):
                    normal_queue.put(process_tmp)
                    print(process_tmp)

def show_process_not_attended(queue, phrase):
    """
    Displays all processes that are in the given queue and have not been attended yet.

    Args:
        queue: The queue containing the processes to be displayed (either normal or priority)
        phrase: A description or title to be displayed before showing the queue
    """
    print(f"\n{phrase}")
    print(f"Total Not Attended Process: {queue.qsize()}")

    # Display each process in the queue
    # We need to make a copy of the queue to iterate through it without removing elements
    queue_copy = list(queue.queue)
    for process in queue_copy:
        print(process)

def main():
    # Initialize the priority and normal queues
    priority_queue = Queue()
    normal_queue = Queue()

    # Generate and distribute the processes between the two queues
    generate_process(priority_queue, normal_queue, 1000)

    # Show the processes that have not been attended in both queues
    show_process_not_attended(priority_queue, "Priority Queue")
    show_process_not_attended(normal_queue, "Normal Queue")

if __name__ == "__main__":
    main()