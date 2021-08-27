#include<bits/stdc++.h>

using namespace std;

double pi = 3.14159;

int main()
{
    float a, b, c;

    cin >> a >> b >> c;
    double triangle = (0.5)*a*c;
    double circle = pi * (c*c);
    double trapizium = ((a+b) / 2)*c;
    double square = b*b;
    double rectangle = a * b;

    printf("TRIANGULO: %.3lf\n", triangle);
    printf("CIRCULO: %.3lf\n", circle);
    printf("TRAPEZIO: %.3lf\n", trapizium);
    printf("QUADRADO: %.3lf\n", square);
    printf("RETANGULO: %.3lf\n", rectangle);

    return 0;
}
