# Advanced Invoice Management System

A comprehensive invoice management system for small businesses, supporting multiple product types, customer categories, payment methods, inventory tracking, and analytics.

## Features

- Customer management (Regular, Premium, Corporate)
- Product management (Physical & Digital, inventory, categories)
- Invoice generation and payment tracking
- File operations (save/load/export/backup)
- Analytics & reporting

## Prerequisites

- Java 11 or higher
- (Optional) IDE like IntelliJ IDEA or VS Code

## Setup

1. **Clone the repository**  
   ```
   git clone <your-repo-url>
   cd Advanced-Invoice-Management-System
   ```

2. **Compile the project**  
   ```
   javac -d bin -sourcepath src src/app/Main.java
   ```

3. **Run the application**  
   ```
   java -cp bin app.Main
   ```

4. **Data Files**  
   - Data is saved in the `data/` directory (created automatically).
   - Backups are stored in the `backup/` directory.

## Usage

- Follow the menu prompts in the terminal to manage customers, products, invoices, and reports.
- Use numeric IDs (4 digits) for customers and products.

## Project Structure

```
app/
  Main.java
model/
  customer/
  invoice/
  product/
  service/
data/
backup/
```
