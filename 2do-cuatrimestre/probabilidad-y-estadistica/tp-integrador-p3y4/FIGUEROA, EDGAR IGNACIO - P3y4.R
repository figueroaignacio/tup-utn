library(readxl)
library(ggplot2)

# Leer la planilla
df <- read_excel("TUPAD-2025-EST-TPI-planilla3.xlsx", sheet = "planilla")

# ---- Histograma: horas de estudio ----
ggplot(df, aes(x = `TIEMPO SEMANAL en HS. DEDIC. EST.`)) +
  geom_histogram(binwidth = 5, fill = "steelblue", color = "black") +
  labs(
    title = "Histograma del tiempo semanal de estudio",
    x = "Horas de estudio semanales",
    y = "Frecuencia"
  )

# ---- Diagrama circular: satisfacción ----
# Primero tabulamos frecuencias
satisf_table <- as.data.frame(table(df$`SATISFACCIÓN CON LA CARRERA`))
colnames(satisf_table) <- c("Categoria", "Frecuencia")

# Convertimos a proporciones
satisf_table$Prop <- satisf_table$Frecuencia / sum(satisf_table$Frecuencia)

# Gráfico circular
ggplot(satisf_table, aes(x = "", y = Prop, fill = factor(Categoria))) +
  geom_col(color = "black") +
  coord_polar(theta = "y") +
  labs(
    title = "Nivel de satisfacción con la carrera",
    fill = "Categoría"
  ) +
  scale_fill_brewer(palette = "Set2")
