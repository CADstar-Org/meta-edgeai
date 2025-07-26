#!/bin/sh

mkdir -p /dev/shm
mount -o defaults,noexec,nodev,nosuid -t tmpfs tmpfs /dev/shm
