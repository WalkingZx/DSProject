#!/bin/bash
kill -9 $(lsof -i:6600 |awk '{print $2}' | tail -n 2)


