"""Simple example module."""

def greet(name: str) -> str:
    """Return a friendly greeting for the provided name."""
    if not name:
        raise ValueError("name must be provided")
    return f"Hallo, {name}!"


if __name__ == "__main__":
    print(greet("wereld"))
