def knapsack(values, weights, capacity):
    n = len(values)  # Number of items
    # Create a 2D array to store maximum value at each n and capacity
    dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

    # Build the table dp[][] in bottom-up fashion
    for i in range(1, n + 1):
        for w in range(1, capacity + 1):
            # Check if the weight of the current item i can be included
            if weights[i - 1] <= w:
                dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])
            else:
                dp[i][w] = dp[i - 1][w]

    # The last cell of the dp table contains the maximum value
    return dp[n][capacity]

# Driver code
if __name__ == "__main__":
    # Input for number of items
    n = int(input("Enter the number of items: "))
    
    # Input for values and weights
    values = []
    weights = []
    
    for i in range(n):
        value = int(input(f"Enter the value for item {i + 1}: "))
        weight = int(input(f"Enter the weight for item {i + 1}: "))
        values.append(value)
        weights.append(weight)

    # Input for the maximum weight capacity of the knapsack
    capacity = int(input("Enter the maximum weight capacity of the knapsack: "))

    # Function call
    max_val = knapsack(values, weights, capacity)
    print(f"The maximum value in the knapsack is: {max_val}")