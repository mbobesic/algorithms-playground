# link: https://open.kattis.com/problems/equivalences
# name: Proving Equivalences
__author__ = 'mislav'
import sys
visited = []
order = []

sys.setrecursionlimit(50000)


def dfs(node):
    global visited, order

    visited[node] = True
    if node in graph:
        for neighbour in graph[node]:
            if visited[neighbour]:
                continue
            dfs(neighbour)

    order.append(node)


def load_graph():

    input_line = raw_input()
    inputs = [int(s) for s in input_line.split()]

    vertices_count = inputs[0]
    edges_count = inputs[1]
    graph = {}

    for vertex in xrange(vertices_count):
        graph[vertex + 1] = []

    for _ in xrange(edges_count):
        input_line = raw_input()
        inputs = [int(s) for s in input_line.split()]
        neighbours = graph[inputs[0]]
        neighbours.append(inputs[1])
        graph[inputs[0]] = neighbours

    return graph


def reverse_graph(graph):

    graph_rev = {}
    for x in xrange(len(graph)):
        graph_rev[x+1] = []

    for first in graph.keys():
        for neighbour in graph[first]:
            current = graph_rev[neighbour]
            current.append(first)
            graph_rev[neighbour] = current

    return graph_rev

if __name__ == "__main__":

    test_cases = int(raw_input())
    for _ in xrange(test_cases):


        graph = load_graph()
        visited = [False] * (len(graph) + 1)
        order = []

        for node in graph.keys():
            if visited[node]:
                continue

            dfs(node)

        graph_rev = reverse_graph(graph)

        visited = [False] * (len(graph_rev) + 1)
        result = [0] * (len(graph_rev)+1)

        for index in xrange(len(order), 0, -1):

            start_node = order[index-1]
            if visited[start_node]:
                continue

            stack = [start_node]
            while len(stack) > 0:
                current = stack.pop()
                if visited[current]:
                    continue

                result[current] = start_node
                visited[current] = True

                for neighbour in graph_rev[current]:
                    stack.append(neighbour)

        dag = {}

        sinks = set()
        sources = set()

        for x in xrange(len(graph)):

            vertex = result[x+1]
            sources.add(vertex)
            sinks.add(vertex)
            neighbours = dag.get(vertex, set())
            for neighbour in graph[vertex]:
                if result[neighbour] != vertex:
                    neighbours.add(neighbour)

            dag[vertex] = neighbours

        if len(dag) == 1:
            print 0
            continue

        for key, value in dag.iteritems():
            if len(value) > 0:
                sinks.discard(key)
                for source in value:
                    sources.discard(source)

        print max(len(sinks), len(sources))

