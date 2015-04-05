# link: https://open.kattis.com/problems/moneymatters
# name: Money Matters
__author__ = 'mislav'


def is_possible(graph, vertex_values, vertex_count):
    visited = [False]*vertex_count

    for vertex in xrange(vertex_count):
        if visited[vertex]:
            continue

        if vertex not in graph.keys():
            if vertex_values[vertex] != 0:
                return False
            continue

        component_sum = 0

        stack = [vertex]
        while len(stack) > 0:
            current_vertex = stack.pop()

            if visited[current_vertex]:
                continue

            visited[current_vertex] = True
            component_sum += vertex_values[current_vertex]

            for neighbour in graph[current_vertex]:
                if not visited[neighbour]:
                    stack.append(neighbour)

        if component_sum != 0:
            return False

    return True


def add_friend(graph, first, second):
    friends = graph.get(first, [])
    friends.append(second)
    graph[first] = friends
    return graph

if __name__ == "__main__":
    input_line = raw_input()
    inputs = [int(s) for s in input_line.split()]
    n = inputs[0]
    m = inputs[1]

    vertex_values = []
    for _ in xrange(n):
        vertex_value = int(raw_input())
        vertex_values.append(vertex_value)

    graph = {}
    for _ in xrange(m):
        input_line = raw_input()
        inputs = [int(s) for s in input_line.split()]
        add_friend(graph, inputs[0], inputs[1])
        add_friend(graph, inputs[1], inputs[0])

    if is_possible(graph, vertex_values, n):
        print "POSSIBLE"
    else:
        print "IMPOSSIBLE"