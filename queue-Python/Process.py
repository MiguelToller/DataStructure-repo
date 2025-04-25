class Process:
    """
    Represents a Process with an ID and description.
    This class provides methods for getting, setting, and comparing process data.
    It also includes a custom string representation of the Process object.
    """

    def __init__(self, id=None, description=None):
         """
        Constructs a Process with the specified ID and description.
        
        Args:
            id: The unique identifier for the process.
            description: A brief description of the process.
        """
         self.id = id
         self.description = description

    def get_id(self):
         return self.id
    
    def set_id(self, id):
         self.id = id

    def get_description(self):
         return self.description
    
    def set_description(self, description):
         self.description = description
    
    def __str__(self):
         """
        Returns a string representation of the process, including its ID and description.
        This is helpful for debugging and logging purposes.
        
        Returns:
            A string representation of the process.
        """
         return f"Process [id={self.id}, description={self.description}]"
    
    def __eq__(self, other):
        """
        Compares this process to another object for equality. Two processes are considered
        equal if their IDs and descriptions are the same.
        
        Args:
            other: The object to compare this process with.
        Returns:
            True if the processes are equal, False otherwise.
        """
        if self is other:
            return True
        if not isinstance(other, Process):
            return False
        return self.description == other.description and self.id == other.id