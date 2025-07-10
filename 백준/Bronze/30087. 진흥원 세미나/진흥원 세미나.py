import sys

n = int(sys.stdin.readline())

semina = {
    'Algorithm' : 204,
    'DataAnalysis' : 207,
    'ArtificialIntelligence' : 302,
    'Network' : 303,
    'CyberSecurity' : 'B101',
    'Startup' : 501,
    'TestStrategy' : 105,
}
for i in range(n):
    temp = sys.stdin.readline().rstrip()
    print(semina[temp])
