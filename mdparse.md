#!/bin/bash
if [[ ! -z "${1}" ]] ; then
	java MarkdownParse "${1}"
fi
