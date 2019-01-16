/*************************************************************
Proyecto:  Uniformes Comercio V2
Descripción: Lista de Scripts
Parámetros de entrada: Ninguno.
Parámetros de salida: Ninguno.
Parámetros de entrada-salida: Ninguno.
Valor de retorno: Resultado de ejecucion de cada línea.
Precondiciones: Ninguna
Creador: Luis Daniel Rodriguez Garcia
Fecha de creación: 27 Diciembre del 2017
*************************************************************/
SET ECHO ON

connect &&UsuarioDBAc3/&&PasswordDBAc3@&&CadenaConexion
@&&RutaDeScripts\UniformesComercio\UNIFORMES\ES\ES0000000007.sql
@&&RutaDeScripts\UniformesComercio\UNIFORMES\AC\AC0000000011.sql
@&&RutaDeScripts\UniformesComercio\UNIFORMES\PR\PR0000000027.sql
@&&RutaDeScripts\UniformesComercio\UNIFORMES\VA\VA0000000003.sql

SET ECHO OFF
