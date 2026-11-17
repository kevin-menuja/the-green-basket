# Architecture — TheGreenBasket Java OOP application

This coursework application is a **Java Swing desktop GUI** generated and maintained using NetBeans forms and a basic text-file storage approach. Its components are local JVM classes, **not** separate web services or a relational database.

## Screen and file interaction

~~~mermaid
flowchart TB
    USER["Local desktop user"] --> LOGIN["LoginForm - credentials and role choice"]
    LOGIN --> MANAGER["ManagerFrame"]
    LOGIN --> SALES["SalesAssistantFrame"]
    LOGIN --> RECORDS[("Local users.txt")]

    MANAGER --> CREATE["CreateUserFrame"]
    CREATE --> RECORDS
    MANAGER --> INVENTORY["InventoryFrame"]
    INVENTORY --> INVFILE[("Local inventory.txt")]

    SALES --> ADD["AddProductFrame"]
    SALES --> SEARCH["SearchProductFrame"]
    SALES --> VIEW["ViewProductFrame"]
    ADD --> PRODUCTS[("Local products.txt")]
    SEARCH --> PRODUCTS
    VIEW --> PRODUCTS
    ADD -.-> MODEL["Product class"]
    VIEW -.-> MODEL
    SEARCH -.-> MODEL
~~~

The diagram reflects direct file operations in the source. A generated NetBeans main screen is shown for each role. The inventory interface expects a local inventory file, which may be empty when first run.

## Source inventory

| Source class | Verified responsibility |
| --- | --- |
| LoginForm | Reads local users file and selects manager or sales-assistant interface; includes a hard-coded demo administrator path |
| ManagerFrame | Provides management navigation |
| SalesAssistantFrame | Provides sales-assistant navigation |
| CreateUserFrame | Appends basic user records to local users.txt |
| AddProductFrame | Appends new product records to products.txt |
| SearchProductFrame | Reads products.txt and filters visible rows |
| ViewProductFrame | Displays and removes product rows from a text file |
| InventoryFrame | Reads local inventory.txt for the status view |
| Product | Represents product fields in Java code |

NetBeans metadata and .form designer files are retained for editing the original GUI. Generated build/classes and machine-local nbproject/private settings are excluded.

## Trade-offs

- **Useful for coursework:** Simple persistence allows attention to Java classes, forms, event handling and data manipulation.
- **Data integrity:** Flat files do not provide transaction semantics, concurrent locking, referential integrity or recoverable migrations.
- **Identity risk:** The original exercise includes a hard-coded administrator credential and stores other user passwords in clear text. These flaws are documented, not presented as secure design.
- **UI architecture:** File reading and GUI event handlers are coupled; a production refactor would separate repositories, services and validation from the Swing presentation layer.
- **Compatibility:** The NetBeans project metadata targets Java 21. The prepared sources compiled using javac 21.

The architecture is a picture of the academic application **as implemented**, not a redesign.
