using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace queue_Csharp
{
    internal class Process
    {
        protected int id;
        protected string description;

        public Process()
        {
        }

        public Process(int id, string description)
        {
            this.id = id;
            this.description = description;
        }

        // Properties with getters and setters
        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        public string Description
        {
            get { return description; }
            set { description = value; }
        }

        public override bool Equals(object? obj)
        {
            return obj is Process process &&
                   id == process.id &&
                   description == process.description &&
                   Id == process.Id &&
                   Description == process.Description;
        }

        public override string ToString()
        {
            return $"Process ID: {id}, Description: {description}";
        }
    }
}
