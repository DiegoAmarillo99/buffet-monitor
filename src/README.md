# 🍜 Wok Garden - Sistema de Monitoreo de Buffet

---

## 📌 Descripción

Sistema de monitoreo desarrollado en Java para la gestión de alimentos en un restaurante tipo buffet. Permite registrar el estado de los platillos en tiempo real, así como su temperatura, mostrando alertas visuales y manteniendo un historial persistente.

---

## ⚠️ Problema identificado

En el restaurante Wok Garden, el control de los alimentos se realiza manualmente, lo que provoca:

- Retrasos en la reposición de alimentos
- Falta de visibilidad del estado de los platillos
- Problemas en el control de temperatura
- Ineficiencia en la comunicación entre personal

---

## 💡 Solución

Se desarrolló una aplicación de escritorio que permite:

- Registrar el estado de los platillos (Lleno, Medio, Vacío)
- Registrar temperatura (Caliente, Frío)
- Mostrar alertas visuales con colores
- Guardar historial automáticamente
- Cambiar entre modo claro y oscuro con animación
- Interfaz moderna y fácil de usar

---

## 🏗️ Arquitectura

Usuario  
↓  
Interfaz gráfica (Java Swing)  
↓  
Lógica del sistema  
↓  
Archivo local (historial.txt)  

---

## 📚 Tabla de Contenidos

- [Requerimientos](#requerimientos)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Uso](#uso)
- [Contribución](#contribución)
- [Roadmap](#roadmap)

---

## ⚙️ Requerimientos

### Software:
- Java JDK 11 o superior
- IntelliJ IDEA
- Git

### Hardware:
- Computadora con al menos 4GB de RAM

### Servidores:
- No requiere servidor (aplicación local)

### Base de datos:
- No aplica (uso de archivo local)

---

## 💻 Instalación

### 1. Clonar repositorio

```bash
git clone https://github.com/DiegoAmarillo99/buffet-monitor.git
cd buffet-monitor
