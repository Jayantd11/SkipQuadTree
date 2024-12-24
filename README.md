PROJECT OVERVIEW

PointsDatabase is an advanced data management system developed for the Advanced Data Structures class. This project integrates two powerful data structures—a Skip List and a PR QuadTree—to efficiently store, retrieve, and manage spatial data points. By leveraging the strengths of both structures, PointsDatabase offers optimized performance for both name-based and location-based queries.

FEATURES

- Dual Data Organization: Utilizes a Skip List for efficient name-based operations and a PR QuadTree for optimized spatial queries.
- Comprehensive Command Support: Handles insertion, removal, searching, region-based queries, duplicate detection, and system dumps.
- Robust Error Handling: Ensures data integrity by validating inputs and maintaining consistent states across both data structures.
- Efficient Memory Management: Implements the Flyweight design pattern to minimize memory usage for empty QuadTree nodes.
- Recursive Operations: All core operations on the PR QuadTree are implemented recursively for optimal performance.

DATA STRUCTURES USED

Skip List

- Purpose: Organizes points by their names.
- Advantages: Provides efficient search, insertion, and deletion operations with average-case logarithmic time complexity.
- Implementation Details: Stores points sorted by their names using String's `compareTo()` method. Allows multiple points with the same name or spatial position, but not both.

PR QUAD TREE

- Purpose: Organizes points by their spatial positions for efficient spatial queries.
- Advantages: Optimized for region searches and intersection queries within a defined 2D space.
- Implementation Details:
  - Node Types:
    - Internal Nodes: Have four children representing NW, NE, SW, and SE quadrants.
    - Leaf Nodes: Contain one or more points.
    - Empty Nodes: Utilize a Flyweight pattern to minimize memory usage.
  - World Boundary: Defined as a 1024x1024 units square with the upper-left corner at (0, 0).
  - Split & Merge Rules:
    - Split: A leaf node splits into an internal node when it contains more than three points with distinct coordinates.
    - Merge: Four sibling leaf nodes merge back into a single leaf node if the decomposition rule is satisfied post-deletion.

DESIGN CONSIDERATIONS

- Database Class: Centralizes command processing and delegates operations to the Skip List and PR QuadTree.
- Inheritance in PR QuadTree: Implements a base class or interface for QuadTree nodes, with specialized subclasses for internal and leaf nodes.
- Flyweight Pattern: Utilizes a single instance for empty leaf nodes to optimize memory usage.
- Recursive Operations: Ensures all PR QuadTree operations (insert, remove, regionsearch, duplicates) are implemented recursively for efficiency.
- Shared Point Objects: Both data structures maintain pointers to shared point objects to ensure consistency and avoid duplication.

CONCLUSION

PointsDatabase effectively demonstrates the practical application of advanced data structures in managing and querying spatial data. By combining the strengths of Skip Lists and PR QuadTrees, it provides a robust and efficient system suitable for various data management scenarios.
