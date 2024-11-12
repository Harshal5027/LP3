# Iterative Fibonacci with Step Count

def fibonacci_iterative(n):
    step_count = 0  # Initialize step count
    a, b = 0, 1
    for i in range(n):
        step_count += 1  # Counting each loop iteration
        a, b = b, a + b  # Updating values of a and b
    return a, step_count

# Input from the user
n = int(input("Enter the value of n: "))
result, step_count = fibonacci_iterative(n)

print(f"Fibonacci({n}) = {result}")
print(f"Step Count (Iterative): {step_count}")



#--------------------------------------------------------------------------------------
# Recursive Fibonacci with Step Count

step_count = 0

def fibonacci_recursive(n):
    global step_count
    step_count += 1
    if n <= 1:
        return n
    return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2)

# Input from the user
n = int(input("Enter the value of n: "))
result = fibonacci_recursive(n)

print(f"Fibonacci({n}) = {result}")
print(f"Step Count: {step_count}")
